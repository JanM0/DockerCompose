#build container
FROM node:13.12.0-alpine as build
WORKDIR /app
ENV PATH /app/node_modules/.bin:$PATH

COPY package.json ./
COPY package-lock.json ./

RUN npm ci
RUN npm install react-scripts@3.4.1 -g
COPY . ./
ARG REACT_APP_BACKEND
ENV REACT_APP_BACKEND $REACT_APP_BACKEND

RUN npm run build

#production image
FROM nginx:stable-alpine
COPY --from=build /app/build /usr/share/nginx/html
#nginx config to enable react router
COPY nginx/nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]

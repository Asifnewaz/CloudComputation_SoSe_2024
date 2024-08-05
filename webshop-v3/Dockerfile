FROM node:20-alpine as build

WORKDIR /app

COPY package*.json ./

RUN npm install

# RUN npm install -g @angular/cli

COPY . .

RUN npm run build

FROM nginx:alpine

COPY --from=build /app/dist/webshop-v2/browser /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]

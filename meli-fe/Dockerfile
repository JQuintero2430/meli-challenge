# meli-fe/Dockerfile
FROM node:20-alpine
WORKDIR /app
COPY . .
RUN npm install && npm run build
EXPOSE 4321
CMD ["npm", "run", "preview"]

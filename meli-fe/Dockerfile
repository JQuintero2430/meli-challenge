# meli-fe/Dockerfile
FROM node:22-alpine
WORKDIR /app
COPY . .
RUN npm install && \
    npm install @astrojs/node --save-dev && \
    npm run build
EXPOSE 4321
CMD ["npm", "run", "preview"]

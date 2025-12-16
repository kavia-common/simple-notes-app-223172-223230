# Notes Backend (Spring Boot)

A simple Spring Boot application exposing RESTful CRUD APIs for managing notes.

- Runs on port 3001
- In-memory persistence (thread-safe)
- Validation for inputs (400)
- 404 when note not found
- OpenAPI docs at `/v3/api-docs` and Swagger UI at `/swagger-ui.html`
- CORS enabled for common local origins

## Endpoints

- POST /api/notes
- GET /api/notes
- GET /api/notes/{id}
- PUT /api/notes/{id}
- DELETE /api/notes/{id}

## Models

Note:
- id: UUID
- title: non-empty string
- content: string
- createdAt: ISO-8601 Instant
- updatedAt: ISO-8601 Instant

## Quick start

```
./gradlew bootRun
```

Then open:
- Swagger UI: http://localhost:3001/swagger-ui.html
- API docs: http://localhost:3001/v3/api-docs

## cURL examples

Create a note:
```
curl -s -X POST http://localhost:3001/api/notes \
  -H "Content-Type: application/json" \
  -d '{"title":"Grocery list","content":"Milk, Bread, Eggs"}'
```

List notes:
```
curl -s http://localhost:3001/api/notes
```

Get a note:
```
curl -s http://localhost:3001/api/notes/{id}
```

Update a note:
```
curl -s -X PUT http://localhost:3001/api/notes/{id} \
  -H "Content-Type: application/json" \
  -d '{"title":"Updated title","content":"Updated content"}'
```

Delete a note:
```
curl -s -X DELETE http://localhost:3001/api/notes/{id} -i
```

Health:
```
curl -s http://localhost:3001/health
```

<h1>🍽️ Restaurant Reservation System</h1>

<p>A RESTful API built with Spring Boot that manages table reservations for a restaurant.<br>
Admins can configure tables and weekly opening hours, while users can request reservations based on availability.</p>

<hr>

<h2>⚙️ Tech Stack</h2>
<ul>
  <li>Java 17</li>
  <li>Spring Boot (Spring Web, Spring Data JPA)</li>
  <li>PostgreSQL</li>
  <li>Lombok</li>
  <li>Postman for API testing</li>
</ul>

<hr>

<h2>🧩 Main Entities</h2>

<h3>🪑 Restaurant Table</h3>
<ul>
  <li>Name (e.g. "Table 1")</li>
  <li>Capacity (number of people)</li>
  <li>Indoor / Outdoor</li>
</ul>

<h3>🕒 Opening Hours</h3>
<ul>
  <li>Day of week</li>
  <li>Opening time / Closing time</li>
  <li>Option to mark day as closed</li>
</ul>

<h3>📅 Reservation</h3>
<ul>
  <li>Name / Email / Phone</li>
  <li>Date / Duration (Start time - End time)</li>
  <li>Party size</li>
  <li>System checks availability & assigns table if possible</li>
</ul>

<hr>

<h2>🔗 API Endpoints</h1>

   <h3>Tables (Admin)</h3>
    <ul>
      <li><code>POST /api/restaurant/admin/table</code> — Create a new table</li>
      <li><code>GET /api/restaurant/admin/tables</code> — Get all tables</li>
      <li><code>GET /api/restaurant/admin/table/{id}</code> — Get a specific table</li>
      <li><code>PUT /api/restaurant/admin/table/{id}</code> — Update a specific table</li>
      <li><code>DELETE /api/restaurant/admin/table/{id}</code> — Delete a specific table</li>
  </ul>
  
   <h3>Opening Hours (Admin / Read-only for Users)</h3>
    <ul>
      <li><code>POST /api/restaurant/admin/opening_hours</code> — Create new opening hours</li>
      <li><code>GET /api/restaurant/opening_hours</code> — View opening hours</li>
      <li><code>PUT /api/restaurant/admin/opening_hours/{day}</code> — Update opening hours</li>
      <li><code>DELETE /api/restaurant/admin/opening_hours</code> — Delete all opening hours</li>
  </ul>
  
   <h3>Reservations (User)</h3>
    <ul>
      <li><code>POST /api/restaurant/reservation</code> — Create a reservation (system auto-assigns a table)</li>
      <li><code>GET /api/restaurant/admin/reservations</code> — (Admin only) View all reservations</li>
      <li><code>DELETE /api/restaurant/admin/reservations</code> — Delete all reservations</li>
      <li><code>DELETE /api/restaurant/admin/reservation/{id}</code> — Delete a specific reservation</li>
  </ul>

<hr>

<h2>📌 Assumptions</h2>
<ul>
  <li>No authentication implemented (admin/user separation is theoretical for now)</li>
  <li>A reservation is valid only if there is an available table at the requested time</li>
  <li>Opening hours and Tables are editable only by admins</li>
</ul>

<hr>

<h2>🔮 Future Enhancements</h2>
<ul>
  <li>Add JWT-based authorization</li>
  <li>Add Swagger for live API documentation</li>
  <li>Add Docker support for deployment</li>
</ul>

<hr>

<h2>👤 Author</h2>
<ul>
  <li>Antonis Mourtzakis</li>
  <li>antmourtzakis@gmail.com</li>
  <li><a href="https://www.linkedin.com/in/antonis-mourtzakis/" target="_blank">LinkedIn Profile</a></li>
</ul>



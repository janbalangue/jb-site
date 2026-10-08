# jb-site

Personal website built with Spring Boot + Thymeleaf, designed as a clean, fast, editorial-style home for my work in software, writing, and music.

This site powers my landing page, project highlights, and contact info, server-rendered with zero frontend frameworks.

## 🌐 Live Site

🌎 **https://jb-site.dev**  
(Primary domain via Cloudflare)

🚀 https://jb-site.fly.dev  
(Fly.io deployment URL)

Deployed on Fly.io using Docker. Server-rendered with Spring Boot 4.x + Thymeleaf.

## ✨ Features

* Spring Boot 4 + Thymeleaf server-rendered pages
* GraalVM native image build for fast cold starts
* Light, editorial UI with custom CSS (no frameworks)
* Single-page layout: Music, Writing, Software, Elsewhere, and Contact sections
* Responsive hero layout with image header
* Back-to-top link with smooth scrolling
* Modular fragment-based layout for easy iteration
* YouTube video embeds for recent piano releases
* Actuator health checks for production readiness

## 🧱 Tech Stack

* **Backend**: Spring Boot 4, Java
* **Templating**: Thymeleaf
* **Frontend**: Vanilla HTML, CSS, JavaScript
* **Fonts**: Libre Baskerville, Inter, IBM Plex Mono (Google Fonts)
* **Build**: Maven

## 📁 Project Structure

```css
jb-site/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── io/janbalangue/jbsite
                └── config
                    └── SiteStats.java
                └── web
                    └── GlobalModelAttributes.java
│   │   │           └── PageController.java
│   │   │           └── ColdStartWarmup.java
│   │   └── resources/
            ├── application.properties
│   │       ├── static
│   │       │   ├── styles.css
│   │       │   ├── jay.js
│   │       │   └── images/
│   │       │       └── header-piano.png
│   │       └── templates/
│   │           ├── layout.html
│   │           ├── index.html
│   │           └── fragments/
│   │               ├── music.html
│   │               ├── writing.html
│   │               └── software.html
│   └── test/
├── pom.xml
└── README.md
```

## 🚀 Running Locally

### Prerequisites

* Java 25+
* Maven 3.9+

Run the app:
`mvn spring-boot:run`


Then open:

http://localhost:8080

## Actuator Endpoints

This application exposes minimal Spring Boot Actuator endpoints for production readiness.

Base path:

```txt
/actuator
```

Exposed endpoints:

```txt
GET /actuator/health
GET /actuator/health/liveness
GET /actuator/health/readiness
```

Only the `health` endpoint is exposed over HTTP.
Liveness and readiness probes are enabled for Fly.io deployment health checks.

## 🧩 Notable UI Patterns 

### Section Fragments

The Music, Writing, and Software sections each live in their own fragment and are composed into the home page:

```html
<th:block th:replace="~{fragments/music}"/>
```

Each one is also served standalone at `/fragments/music`, `/fragments/writing`, and `/fragments/software`.

### Layout Composition

All pages render inside a shared Thymeleaf layout:

```html
<html th:replace="~{layout :: layout(~{::content})}">
```

This keeps global styles, scripts, and navigation consistent.

## 🎵 Content Areas

* **Music**: YouTube video embeds plus SoundCloud, YouTube, Spotify, and Apple Music links
* **Writing**: Substack blog and published novels
* **Software**: Web applications and the Async Bulkhead open-source libraries
* **Elsewhere**: Profile and channel links
* **Contact**: Location, email, and phone

🎯 Design Goals

* Minimal dependencies
* Fast page loads
* Readable, calm, editorial UI
* Server-side rendering first
* Progressive enhancement instead of heavy JS

## 📬 Contact information

> 🏠 Chula Vista, CA

> 📧 jan.a.balangue@gmail.com

> 📞 (858) 775-5831

## 📄 License

Personal project.
All rights reserved unless otherwise stated.

# Build Log

This document captures the evolution of jb-site as it was built and refined.
Rather than tracking releases or versions, it records what was built, adjusted, and fixed during active development.

## 2026-01-20 — Initial Build

### Foundation

* Bootstrapped a Spring Boot 4 application using Thymeleaf for server-side rendering
* Established a shared layout template for header, footer, scripts, and global styles
* Set up static asset handling for CSS, JavaScript, and images
* Defined a dark-mode–first design system using CSS variables

### Home Page & Layout

* Built the hero section with a responsive two-column grid
* Added a header image and resolved static image rendering issues
* Tuned spacing and layout to keep the hero visually calm and readable
* Implemented responsive breakpoints for mobile and tablet layouts

### Interactivity

* Introduced HTMX to progressively enhance the site without heavy JavaScript
* Built the Explore section using HTMX-powered tabs (Music, Writing, Open Source)
* Added client-side tab state handling for visual feedback
* Implemented smooth scrolling for in-page navigation

### Content Areas

* Music section with SoundCloud and YouTube links plus embedded SoundCloud player
* Writing section highlighting Substack blogs and cross-posts
* Open Source section featuring the Async Bulkhead library (published to Maven Central)
* “Get in touch” section with location, email, and phone details

### UI Polish

* Added pill-style stat cards for highlights (Substack, YouTube, Open Source)
* Introduced card-based layouts for content sections
* Ensured consistent typography, contrast, and spacing across the site
* Added a floating “scroll to top” button with visibility and animation logic

### Fixes & Adjustments

* Resolved CSS not loading due to Spring Boot static resource path issues
* Fixed header image placeholders rendering without the actual image
* Diagnosed and corrected HTMX behavior where only the first tab rendered
* Cleaned up Thymeleaf fragment usage that caused layout inconsistencies
* Adjusted scroll behavior to avoid abrupt jumps

### Notes

* This log reflects one focused build session with heavy iteration
* Many changes were incremental and driven by visual inspection and behavior testing
* Future entries will be added only when meaningful structural or content changes occur

---

## 2026-01-23

### Accomplishments & Content Updates

* Updated `index.html` and all Explore fragments with new accomplishments and current stats
* Refreshed copy to better reflect recent progress across music, writing, and open source work
* Ensured consistency between homepage highlights and fragment content

### Media Embeds

* Added YouTube video embed to the Music section for native playback
* Tuned spacing so audio and video embeds feel intentional and unobtrusive
* Preserved responsive behavior across desktop and mobile

### UI / UX Polish

* Maintained visual balance between embeds, cards, and text
* Kept embeds aligned with the site’s dark-mode–first design language
* Avoided layout shift when loading HTMX fragments

### Notes

* This push focuses on content maturity and presentation rather than new architecture
* Media embeds are now first-class elements instead of external links
* Sets a stable baseline before further iteration on discoverability or navigation

---

## 2026-01-23

* Refined panel hover interactions across the site for a subtler, calmer feel
* Reduced hover lift, glow, and animation intensity to improve visual restraint
* Slowed hover transitions for smoother, more intentional motion
* Disabled hover effects on the Get in Touch section to keep the contact area grounded and static
* Verified static asset loading and cache-busting during local development

---

## 2026-01-23

* Separated async-bulkhead and async-bulkhead-ts into distinct miniCards and added margin-bottom: 16px to improve spacing and readability

---

## 2026-01-23

Fix missing scroll-to-top button
* Resolved issue where the scroll-to-top button was not visible due to the global hover system overriding its position: fixed and z-index.
* Removed .scrollTopBtn from the global hover selector group to prevent layout clobbering.
* Reasserted fixed positioning and layering for the scroll button and applied a subtle, scoped hover effect consistent with the site’s interaction style.

---

## 2026-01-25

* Removed inline Maven dependency snippet from the Open Source tab
* Simplified async-bulkhead presentation to focus on project intent and links rather than install instructions
* Reduced visual noise in the OSS panel to keep the section concise and scannable
* Preserved direct links to GitHub and Maven Central for users who want implementation details

---

## 2026-01-26

* Updated Fly.io setting `min_machines_running` to `1` to eliminate cold starts

---

## 2026-01-27

* Updated embedded SoundCloud track and added a YouTube video embed in the Music section
* Refreshed Music, Writing, and Open Source fragments with current accomplishments
* Aligned fragment content with homepage highlights and verified stable HTMX loading

---

## 2026-01-27

* Removed Medium listing as this project will be discontinued for now.

---

## 2026-02-03

### Accomplishments

* Updated accomplishment metrics and milestones to reflect current impact and activity.
* Refined language around open-source and technical work to better represent scope, maturity, and outcomes.
* Adjusted counts / highlights to align with latest public stats and platforms.

### Descriptions & copy

* Rewrote section descriptions for clarity and tone, focusing on what I actually do and why it matters.
* Tightened phrasing to reduce fluff and improve scannability while retaining my authentic voice.
* Clarified distinctions between areas of work (engineering, writing, music, etc.) through more precise wording.
* Made small consistency passes so terminology and framing match across sections.

### Notes

* No structural, layout, styling, JavaScript, or architectural changes in this update.
* This was a content-only pass focused on accuracy, clarity, and presentation of achievements.

---

## 2026-02-03

### Music Highlights

* Added a SoundCloud pill to the homepage highlights row
* Surfaced SoundCloud presence alongside Substack, YouTube Music, and Open Source
* Kept the pill consistent with existing stat styling and dark-mode visual balance
* Reinforced music as a first-class pillar of the site at a glance

### Notes

* This change improves immediate discoverability of music work without adding visual noise
* Pills continue to function as lightweight, high-signal credibility markers rather than navigation

---

## 2026-02-06

### Performance & Content Cleanup

* Added explicit cache-control configuration to application.properties to improve static asset caching behavior in production
* Tuned HTTP cache headers for CSS, JavaScript, and image assets to reduce repeat load times and unnecessary revalidation
* Laid groundwork for CDN-friendly caching (Cloudflare / edge caching) without changing application code paths

### Quick Links Refinement

* Removed Buy Me a Coffee from the Quick Links section to reduce donation surface clutter
* Updated the Maven Central link to point directly to the async-bulkhead artifact page instead of legacy or indirect references
* Kept Quick Links focused on primary platforms (code, writing, music) rather than secondary support links

### Notes

* This change is intentionally low-visibility but improves perceived performance and polish
* Quick Links now better reflect current priorities: published work over tip jars
* Sets up cleaner long-term caching strategy ahead of further Cloudflare tuning

---

## 2026-02-06

### Content Refinement & Copy Polish

* Refined copy across Music, Writing, and Software cards to improve clarity, tone, and consistency
* Reworded Music descriptions to better emphasize reinterpretation, eclecticism, and performance focus
* Updated Writing copy to clearly reference Substack while keeping the language concise and reflective
* Tightened Software card language to better convey resilience and asynchronous systems without buzzwords

### MiniCard Updates

* Rephrased SoundCloud, YouTube, and Patreon miniCards for clearer scannability and parallel structure
* Emphasized solo piano, performance-focused video content, and high-quality music downloads
* Preserved existing layout and hierarchy while improving readability

### Notes

* No structural or styling changes — content-only pass
* Focused on reducing repetition and sharpening intent across cards
* Improves first-read comprehension without changing page flow

---

## 2026-02-21 — GraalVM native image + cold-start + Fly tuning

### Summary
Migrated the app to **GraalVM native image (Spring Boot 4 AOT)** to reduce cold-start latency and runtime memory. Updated Fly.io configuration and health checks for stable production deploys.

### Build System (Maven)

- Added `org.graalvm.buildtools:native-maven-plugin`
- Added `native` profile:
    - Enables Spring AOT (`spring.aot.enabled=true`)
    - Runs `spring-boot:process-aot`
    - Builds native executable named `jb-site`
- Added `spring-boot-starter-actuator` for infra health checks

Native build command:

```bash
mvn -Pnative -DskipTests native:compile
```

### Docker

- Converted from JVM JAR image to **GraalVM native multi-stage build**
- Runtime now executes compiled binary directly (no JVM)
- Ensured Maven wrapper is committed for Docker builds

Notes:
- Use `fly deploy --remote-only` if building from Apple Silicon
- Alternatively build with `--platform linux/amd64`

### Cold Start Optimization

- Added `ColdStartWarmup` component
    - Pre-renders:
        - `index`
        - `fragments/music`
        - `fragments/writing`
        - `fragments/oss`
    - Primes Thymeleaf parsing & expression caches
    - Reduces first-request latency after scale-to-zero

- Hoisted `stats` map in `PageController` to static constant to reduce per-request allocations

- Enabled:

```properties
spring.thymeleaf.cache=true
```

### Health & Readiness

- Exposed Actuator health endpoints:
- `/actuator/health`
- `/actuator/health/liveness`
- `/actuator/health/readiness`
- Fly health check now uses:

```toml
/actuator/health/readiness
```
- Increased health check grace period to 30s
- Explicitly bound server:

```properties
server.address=0.0.0.0
server.port=8080
```

Removed custom `/health` endpoint in favor of Actuator.

### Fly.io Configuration

- `min_machines_running = 1` (stability during rollout)
- Memory reduced from 1GB → **512MB**
- VM config:
- `memory = "512mb"`
- `memory_mb = 512`

512MB chosen as stable production baseline for:
- Native Spring Boot 4
- Thymeleaf
- Actuator
- Cold-start warmup

Can consider lowering later if memory metrics remain low.

### Outcome

- Faster cold starts
- Lower runtime memory vs JVM
- Cleaner health checks
- Stable Fly deployment
- Native binary production build

---

## 2026-02-23 – Centralized Site Stats (Single Source of Truth)

### Summary
Refactored site-wide statistics (subscribers, followers, versions) to be defined in one place and automatically injected into all Thymeleaf templates — including HTMX fragment renders.

### Changes

#### 1. Introduced `SiteStats` configuration bean
- Added `@ConfigurationProperties(prefix = "site.stats")`
- Moved all subscriber counts and library versions into `application.properties`
- Added safe default values at the configuration layer to eliminate null checks in templates

#### 2. Added global model injection
- Created `@ControllerAdvice` (`GlobalModelAttributes`)
- Injected `stats` into every Thymeleaf render (full pages + fragments)
- Removed per-controller stat wiring

#### 3. Removed hardcoded values from templates
Updated:
- `index.html`
- `fragments/writing.html`
- `fragments/oss.html`

Replaced hardcoded:
- Substack subscriber counts
- Follower counts
- "Since" dates
- Maven/npm version numbers

All values now use:

```html
<span th:text="${stats.*}"></span>
```

---

## 2026-04-01

### Software Section Rename & Routing Fix

- Renamed the Explore fragment from `oss.html` to `software.html` to better match the broader scope of the section. :contentReference[oaicite:0]{index=0}
- Updated the HTMX tab route from `/fragments/oss` to `/fragments/software` and aligned the controller mapping to return `fragments/software`. :contentReference[oaicite:1]{index=1} :contentReference[oaicite:2]{index=2}
- Resolved the Thymeleaf template lookup issue caused by the fragment rename mismatch. :contentReference[oaicite:3]{index=3}

### Content Expansion

- Expanded the Software section to highlight WriteReps, wdmueller.com, async-bulkhead-llm, async-bulkhead-ts, and async-bulkhead. :contentReference[oaicite:4]{index=4}
- Refreshed the homepage Software card to reflect broader product and engineering work beyond open source alone. :contentReference[oaicite:5]{index=5}
- Updated Music and Writing fragments with refreshed copy, current links, and improved positioning of current work. :contentReference[oaicite:6]{index=6} :contentReference[oaicite:7]{index=7}

### Site Stats & Warmup

- Updated site-wide stats and version metadata in `application.properties`, including SoundCloud, Substack, YouTube, WriteReps, and async-bulkhead-llm values. :contentReference[oaicite:8]{index=8}
- Extended `SiteStats` to include `writeRepsVersion` and `bulkheadLlmVersion` so new product and library metadata can be rendered consistently across templates. :contentReference[oaicite:9]{index=9}
- Updated cold-start warmup to preload `fragments/software` so the renamed fragment participates in template cache priming. :contentReference[oaicite:10]{index=10}

### Notes

- This update combines a naming cleanup, a routing fix, and a broader content refresh.
- The Software section now reflects both product work and open-source work more accurately.
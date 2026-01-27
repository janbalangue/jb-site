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
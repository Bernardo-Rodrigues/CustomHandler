# CustomHandler for WSO2 API Manager

This project provides a custom **Synapse Handler** for the WSO2 API Manager. Its purpose is to **inject API tags** into the request context during runtime, enabling custom behavior or analytics based on these tags.

## 🔧 What It Does

The `CustomHandler` class sets a Synapse property named `API_TAGS` using a comma-separated list of tags configured via the handler’s properties. These tags can then be used in the mediation flow for logging, routing, analytics, or policy enforcement.

## 📦 Class: `CustomHandler`

### Key Behavior
- Reads a `listOfTags` property (comma-separated string).
- Cleans whitespace and injects it into the message context as the `API_TAGS` property.
- Skips execution if no tags are provided.
- Only affects **request flow**; response flow is left untouched.

### Example Tag Configuration

```xml
<handler class="org.example.wso2.CustomHandler">
   <property name="listOfTags" value="public,internal,analytics"/>
</handler>
```

## Related article

https://medium.com/@bernardo.rodrigues06/injecting-api-metadata-into-wso2-apim-gateway-runtime-490961ae29f2
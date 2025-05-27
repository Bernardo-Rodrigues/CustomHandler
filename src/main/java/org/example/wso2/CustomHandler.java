package org.example.wso2;

import org.apache.synapse.MessageContext;
import org.apache.synapse.rest.AbstractHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * CustomHandler sets a Synapse property named 'API_TAGS' using a configured list of tags.
 */
public class CustomHandler extends AbstractHandler {

    private static final Log log = LogFactory.getLog(CustomHandler.class);

    /**
     * Comma-separated list of tags, injected via handler property configuration.
     */
    private String listOfTags = "";

    @Override
    public boolean handleRequest(MessageContext messageContext) {
        // Set the Synapse property to be used elsewhere in the mediation flow
        messageContext.setProperty("API_TAGS", listOfTags);

        log.info("CustomHandler: Set Synapse property [API_TAGS] = " + listOfTags);
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext) {
        // No special handling needed for responses
        return true;
    }

    /**
     * Setter required by Synapse to inject the handler property.
     *
     * @param listOfTags comma-separated string of tags
     */
    public void setListOfTags(String listOfTags) {
        if (listOfTags == null || listOfTags.isBlank()) {
            log.warn("CustomHandler: No tags provided in 'listOfTags'.");
            return;
        }

        // Remove whitespace and format tags
        String cleanedTags = listOfTags.trim().replaceAll("\\s+", "");

        this.listOfTags = cleanedTags;
    }
}
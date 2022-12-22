# EPG SOLUTION

REST API in Java/Springboot to provide EPG information.

## Endpoints

### Channels API
    /channels/create [Create a channel]

    /channels [Provides all channels]

### Programs API
    /programs/create [Create a program]
   
    /programs/channel/{id} [Provides all programs by channel id]

    /programs/{id} [Provides the program detail by id]
   
    /programs/{id} [Delete the program by id]

    /programs/{id} [Update the program by id]

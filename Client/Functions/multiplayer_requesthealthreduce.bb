Function multiplayer_requesthealthreduce%(arg0%, arg1$)
    udp_bytestreamwritechar($7C)
    udp_bytestreamwriteline(arg1)
    udp_bytestreamwriteshort(arg0)
    udp_setmicrobyte($7C)
    Return $00
End Function

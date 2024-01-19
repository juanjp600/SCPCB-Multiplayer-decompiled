Function multiplayer_list_updateserver%(arg0.servers, arg1%, arg2%)
    If (server_list_stream = $00) Then
        Return $FFFFFFFF
    EndIf
    If (arg0 = Null) Then
        Return $00
    EndIf
    If (((arg0\Field11 <> $00) And (arg2 = $01)) <> 0) Then
        Return $00
    EndIf
    If (counthostips(arg0\Field1) = $00) Then
        Return $00
    EndIf
    arg0\Field18 = hostip($01)
    arg0\Field12 = (millisecs() + arg1)
    arg0\Field11 = millisecs()
    writebyte(server_list_stream, $23)
    writebyte(server_list_stream, $00)
    writebyte(server_list_stream, arg2)
    sendudpmsg(server_list_stream, arg0\Field18, (Int arg0\Field2))
    Return $00
End Function

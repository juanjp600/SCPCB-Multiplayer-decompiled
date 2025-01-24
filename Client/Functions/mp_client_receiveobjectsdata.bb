Function mp_client_receiveobjectsdata%(arg0%)
    Local local0%
    If (arg0 = $07) Then
        Repeat
            local0 = mp_readbyte()
            If (local0 = $00) Then
                Exit
            EndIf
            mp_client_receiveroomobject(local0)
        Forever
    Else
        Repeat
            local0 = mp_readbyte()
            If (local0 = $00) Then
                Exit
            EndIf
            mp_client_receiveroomlever(local0)
        Forever
    EndIf
    Return $00
End Function

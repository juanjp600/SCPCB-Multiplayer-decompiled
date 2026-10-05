Function udp_setmicrobyte%(arg0%)
    If (iscoopmode() <> 0) Then
        udp_sendmessage($00)
    EndIf
    Return $00
End Function

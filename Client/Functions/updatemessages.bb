Function updatemessages%()
    If (((selecteddifficulty\Field0 = difficulties[$03]\Field0) Lor (opt\Field32 = $00)) <> 0) Then
        Return $00
    EndIf
    If (0.0 < msg\Field1) Then
        msg\Field1 = (msg\Field1 - fps\Field7[$00])
    Else
        msg\Field1 = 0.0
        msg\Field0 = ""
    EndIf
    Return $00
End Function

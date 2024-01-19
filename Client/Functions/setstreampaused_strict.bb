Function setstreampaused_strict%(arg0%, arg1%)
    Local local0.stream
    local0 = (Object.stream arg0)
    If (local0 = Null) Then
        Return $00
    EndIf
    If (((local0\Field1 = $00) Or (local0\Field1 = $FFFFFFFF)) <> 0) Then
        Return $00
    EndIf
    fsound_setpaused(local0\Field1, arg1)
    local0\Field5 = arg1
    Return $00
End Function

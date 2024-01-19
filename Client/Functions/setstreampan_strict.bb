Function setstreampan_strict%(arg0%, arg1#)
    Local local0.stream
    Local local1%
    local0 = (Object.stream arg0)
    If (local0 = Null) Then
        Return $00
    EndIf
    If (((local0\Field1 = $00) Or (local0\Field1 = $FFFFFFFF)) <> 0) Then
        Return $00
    EndIf
    local1 = $00
    local1 = (Int ((127.5 * arg1) + 127.5))
    fsound_setpan(local0\Field1, local1)
    local0\Field4 = (Float local1)
    Return $00
End Function

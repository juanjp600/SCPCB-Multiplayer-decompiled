Function setstreampan_strict%(arg0%, arg1#)
    Local local0.stream
    Local local1%
    local0 = (Object.stream arg0)
    If (local0 = Null) Then
        createconsolemsg("Failed to find stream Sound: Unknown Stream", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Return $00
    EndIf
    If (((local0\Field1 = $00) Or (local0\Field1 = $FFFFFFFF)) <> 0) Then
        createconsolemsg(("Failed to find stream Sound: Returned " + (Str local0\Field1)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Return $00
    EndIf
    local1 = ((Int (127.0 * arg1)) + $7F)
    fsound_setpan(local0\Field1, local1)
    local0\Field4 = (Float local1)
    Return $00
End Function

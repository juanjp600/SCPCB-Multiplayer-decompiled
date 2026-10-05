Function isstreamplaying_strict%(arg0%)
    Local local0.stream
    If (arg0 = $00) Then
        Return $00
    EndIf
    local0 = (Object.stream arg0)
    If (local0 = Null) Then
        createconsolemsg("Failed to find stream Sound: Unknown Stream", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Return $00
    EndIf
    If (((local0\Field1 = $00) Or (local0\Field1 = $FFFFFFFF)) <> 0) Then
        createconsolemsg(("Failed to find stream Sound: Returned " + (Str local0\Field1)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Return $00
    EndIf
    Return fsound_isplaying(local0\Field1)
    Return $00
End Function

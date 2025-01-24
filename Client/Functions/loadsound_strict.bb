Function loadsound_strict%(arg0$)
    Local local0.sound
    If (filetype((lang\Field1 + arg0)) = $01) Then
        arg0 = (lang\Field1 + arg0)
    EndIf
    local0 = (New sound)
    local0\Field1 = arg0
    local0\Field0 = $00
    local0\Field3 = $00
    If (opt\Field22 = $00) Then
        If (local0\Field0 = $00) Then
            local0\Field0 = loadsound(local0\Field1)
            createsubtitlestoken(local0\Field1, local0)
        EndIf
    EndIf
    Return (Handle local0)
    Return $00
End Function

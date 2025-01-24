Function freesound_strict%(arg0%)
    Local local0.sound
    local0 = (Object.sound arg0)
    If (local0 <> Null) Then
        If (local0\Field0 <> $00) Then
            freesound(local0\Field0)
            local0\Field0 = $00
            removesubtitlestoken(local0)
        EndIf
        Delete local0
    EndIf
    Return $00
End Function

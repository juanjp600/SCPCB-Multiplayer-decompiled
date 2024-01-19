Function freesound_strict%(arg0%)
    Local local0.sounds
    local0 = (Object.sounds arg0)
    If (local0 = Null) Then
        Return $00
    EndIf
    freesound(local0\Field0)
    Delete local0
    Return $00
End Function

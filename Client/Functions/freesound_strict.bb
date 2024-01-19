Function freesound_strict%(arg0%)
    Local local0%
    Local local1.sound
    local1 = (Object.sound local0)
    If (local1 <> Null) Then
        If (local1\Field0 <> $00) Then
            freesound(local1\Field0)
            local1\Field0 = $00
        EndIf
        Delete local1
    EndIf
    Return $00
End Function

Function autoreleasesounds%()
    Local local0.sound
    Local local1%
    Local local2%
    Local local3%
    local1 = millisecs()
    For local0 = Each sound
        local2 = $01
        For local3 = $00 To $0F Step $01
            If (local0\Field2[local3] <> $00) Then
                If (channelplaying(local0\Field2[local3]) <> 0) Then
                    local2 = $00
                    local0\Field3 = (local1 + $1388)
                    Exit
                EndIf
            EndIf
        Next
        If (local2 <> 0) Then
            If (local0\Field3 < local1) Then
                If (local0\Field0 <> $00) Then
                    freesound(local0\Field0)
                    local0\Field0 = $00
                    removesubtitlestoken(local0)
                EndIf
            EndIf
        EndIf
    Next
    Return $00
End Function

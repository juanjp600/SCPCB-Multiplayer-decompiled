Function autoreleasesounds%()
    Local local0.sound
    Local local1%
    Local local2%
    If (enablesfxrelease <> 0) Then
        For local0 = Each sound
            local1 = $01
            For local2 = $00 To $1F Step $01
                If (local0\Field2[local2] <> $00) Then
                    If (channelplaying(local0\Field2[local2]) <> 0) Then
                        local1 = $00
                        local0\Field4 = (millisecs2() + $1388)
                        Exit
                    EndIf
                EndIf
            Next
            If (local1 <> 0) Then
                If (local0\Field4 < millisecs2()) Then
                    If (local0\Field0 <> $00) Then
                        freesound(local0\Field0)
                        local0\Field0 = $00
                        local0\Field3 = $00
                    EndIf
                EndIf
            EndIf
        Next
    EndIf
    Return $00
End Function

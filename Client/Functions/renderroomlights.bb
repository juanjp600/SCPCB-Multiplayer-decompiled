Function renderroomlights%()
    Local local0.rooms
    Local local1%
    For local0 = Each rooms
        If (local0\Field72 = $00) Then
            For local1 = $00 To local0\Field18 Step $01
                hideentity(local0\Field16[local1])
                hideentity(local0\Field20[local1])
                hideentity(local0\Field21[local1])
                hideentity(local0\Field24[local1])
            Next
            local0\Field72 = $01
        EndIf
    Next
    Return $00
    For local0 = Each rooms
        If ((((hidedistance * 2.0) > local0\Field8) Or (local0 = playerroom)) <> 0) Then
            If (local0\Field72 = $01) Then
                For local1 = $00 To local0\Field18 Step $01
                    showentity(local0\Field16[local1])
                Next
                local0\Field72 = $00
            EndIf
        ElseIf (local0\Field72 = $00) Then
            For local1 = $00 To local0\Field18 Step $01
                hideentity(local0\Field16[local1])
            Next
            local0\Field72 = $01
        EndIf
    Next
    Return $00
End Function

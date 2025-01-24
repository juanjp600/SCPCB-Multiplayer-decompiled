Function updatesoundemitters%()
    Local local0.soundemitters
    For local0 = Each soundemitters
        If (local0\Field4 <> Null) Then
            If (((6.0 > local0\Field4\Field8) Lor (local0\Field4 = playerroom)) <> 0) Then
                If ((local0\Field2 * local0\Field2) > entitydistancesquared(local0\Field0, me\Field60)) Then
                    local0\Field3 = loopsoundex(roomambience[(local0\Field1 - $01)], local0\Field3, camera, local0\Field0, local0\Field2, 1.0, $00)
                EndIf
            EndIf
        EndIf
    Next
    Return $00
End Function

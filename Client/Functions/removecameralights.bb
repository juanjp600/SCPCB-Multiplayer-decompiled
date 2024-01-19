Function removecameralights%()
    Local local0.rooms
    Local local1%
    For local0 = Each rooms
        If ((((hidedistance * 0.7) > local0\Field8) Or (local0 = playerroom)) <> 0) Then
            For local1 = $00 To local0\Field18 Step $01
                hideentity(local0\Field21[local1])
            Next
        EndIf
    Next
    Return $00
End Function

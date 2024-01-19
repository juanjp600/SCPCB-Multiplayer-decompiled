Function findfreeplayerid%()
    Local local0%
    For local0 = $01 To networkserver\Field14 Step $01
        If (player[local0] = Null) Then
            Return local0
        EndIf
    Next
    Return $00
End Function

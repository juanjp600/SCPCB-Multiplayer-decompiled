Function freeplayerobjects%(arg0.players)
    Local local0%
    If (((arg0\Field40 = Null) Or (networkserver\Field20 = arg0\Field0)) <> 0) Then
        Return $00
    EndIf
    If (arg0\Field40\Field6 <> $00) Then
        freeentity(arg0\Field40\Field6)
        freeentity(arg0\Field40\Field4)
        freeentity(arg0\Field40\Field5)
        If (arg0\Field40\Field8 <> $00) Then
            rd_remove(arg0\Field40\Field9[$00])
            rd_remove(arg0\Field40\Field9[$01])
        EndIf
        For local0 = $01 To $0F Step $01
            freeentity(arg0\Field40\Field7[local0])
        Next
        arg0\Field40\Field6 = $00
    EndIf
    Delete arg0\Field40
    Return $00
End Function

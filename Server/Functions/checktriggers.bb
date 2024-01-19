Function checktriggers$(arg0.events)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    If (arg0\Field1\Field38 = $00) Then
        Return ""
    Else
        For local0 = $00 To (arg0\Field1\Field38 - $01) Step $01
            entityalpha(arg0\Field1\Field39[local0], 0.0)
            If (((entityx(arg0\Field13, $00) > ((arg0\Field1\Field47[local0] * arg0\Field1\Field41[local0]) + arg0\Field1\Field3)) And (entityx(arg0\Field13, $00) < ((arg0\Field1\Field47[local0] * arg0\Field1\Field44[local0]) + arg0\Field1\Field3))) <> 0) Then
                If (((entityy(arg0\Field13, $00) > ((arg0\Field1\Field48[local0] * arg0\Field1\Field42[local0]) + arg0\Field1\Field4)) And (entityy(arg0\Field13, $00) < ((arg0\Field1\Field48[local0] * arg0\Field1\Field45[local0]) + arg0\Field1\Field4))) <> 0) Then
                    If (((entityz(arg0\Field13, $00) > ((arg0\Field1\Field49[local0] * arg0\Field1\Field43[local0]) + arg0\Field1\Field5)) And (entityz(arg0\Field13, $00) < ((arg0\Field1\Field49[local0] * arg0\Field1\Field46[local0]) + arg0\Field1\Field5))) <> 0) Then
                        Return arg0\Field1\Field40[local0]
                    EndIf
                EndIf
            EndIf
        Next
    EndIf
    Return ""
End Function

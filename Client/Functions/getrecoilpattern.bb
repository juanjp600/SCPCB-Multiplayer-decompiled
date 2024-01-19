Function getrecoilpattern#(arg0#)
    If (eqquipedgun <> Null) Then
        If (1.01 <= eqquipedgun\Field3) Then
            If (((eqquipedgun\Field0 = $06) And (456.0 > eqquipedgun\Field3)) <> 0) Then
                Return 0.0
            EndIf
            If (rand($00, $01) = $00) Then
                Return ((eqquipedgun\Field11 * 0.2) * fpsfactor)
            Else
                Return ((- (eqquipedgun\Field11 * 0.2)) * fpsfactor)
            EndIf
        EndIf
    EndIf
    Return arg0
    Return 0.0
End Function

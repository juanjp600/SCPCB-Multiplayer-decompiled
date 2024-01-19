Function getrecoilforce#()
    If (eqquipedgun <> Null) Then
        If (1.01 <= eqquipedgun\Field3) Then
            If (((eqquipedgun\Field0 = $06) And (456.0 > eqquipedgun\Field3)) <> 0) Then
                Return 0.0
            EndIf
            If (eqquipedgun\Field29 = $00) Then
                Return (eqquipedgun\Field11 * fpsfactor)
            Else
                Return ((eqquipedgun\Field11 * 0.9) * fpsfactor)
            EndIf
        EndIf
    EndIf
    Return 0.0
End Function

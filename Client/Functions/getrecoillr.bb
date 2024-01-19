Function getrecoillr#()
    Local local0#
    local0 = 0.0
    If (eqquipedgun <> Null) Then
        If (1.0 <= eqquipedgun\Field3) Then
            local0 = (rnd(0.3, 0.4) * fpsfactor)
            If (rand($01, $02) = $01) Then
                local0 = (- local0)
            EndIf
        EndIf
    EndIf
    Return local0
    Return 0.0
End Function

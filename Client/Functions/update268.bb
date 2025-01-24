Function update268%()
    Local local0#
    If (i_268\Field0 > $01) Then
        i_268\Field2 = (0.0 < i_268\Field1)
        i_268\Field3 = 140.0
        If (i_268\Field0 = $03) Then
            local0 = (((((Float i_714\Field0) * 0.5) + 1.0) + (Float (wi\Field0 = $04))) * (fps\Field7[$00] / 2.0))
        Else
            local0 = (((((Float i_714\Field0) * 0.5) + 1.0) + (Float (wi\Field0 = $04))) * fps\Field7[$00])
        EndIf
        i_268\Field1 = max((i_268\Field1 - local0), 0.0)
        If (((1.0 <= i_268\Field1) And (1.0 > (i_268\Field1 - local0))) <> 0) Then
            playsound_strict(loadtempsound("SFX\SCP\268\InvisibilityOff.ogg"), $00)
        EndIf
    Else
        If (0.0 >= i_268\Field3) Then
            i_268\Field1 = min((i_268\Field1 + fps\Field7[$00]), 700.0)
        Else
            i_268\Field3 = (i_268\Field3 - fps\Field7[$00])
        EndIf
        i_268\Field2 = $00
    EndIf
    Return $00
End Function

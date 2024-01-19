Function loadtempsound%(arg0$)
    Local local0%
    If (instr(arg0, " ", $01) = $01) Then
        arg0 = trim(arg0)
    EndIf
    If (tempsounds[tempsoundindex] <> $00) Then
        freesound_strict(tempsounds[tempsoundindex])
    EndIf
    local0 = loadsound_strict(arg0)
    tempsounds[tempsoundindex] = local0
    tempsoundindex = ((tempsoundindex + $01) Mod $0A)
    Return local0
    Return $00
End Function

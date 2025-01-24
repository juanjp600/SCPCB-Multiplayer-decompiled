Function loadtempsound%(arg0$)
    Local local0%
    If (tempsounds[tempsoundindex] <> $00) Then
        freesound_strict(tempsounds[tempsoundindex])
        tempsounds[tempsoundindex] = $00
    EndIf
    local0 = loadsound_strict(arg0)
    tempsounds[tempsoundindex] = local0
    tempsoundindex = ((tempsoundindex + $01) Mod $0A)
    Return local0
    Return $00
End Function

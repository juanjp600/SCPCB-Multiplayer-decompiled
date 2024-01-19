Function isitemgoodfor1162%(arg0.itemtemplates)
    Local local0$
    local0 = arg0\Field2
    Select arg0\Field2
        Case "key1","key2","key3"
            Return $01
        Case "misc","420","cigarette"
            Return $01
        Case "vest","finevest","gasmask"
            Return $01
        Case "radio","18vradio"
            Return $01
        Case "clipboard","eyedrops","nvgoggles"
            Return $01
        Case "drawing"
            If (arg0\Field12 <> $00) Then
                freeimage(arg0\Field12)
            EndIf
            arg0\Field12 = loadimage_strict((("GFX\items\1048\1048_" + (Str rand($01, $14))) + ".jpg"))
            Return $01
        Default
            If (arg0\Field2 <> "paper") Then
                Return $00
            ElseIf (instr(arg0\Field1, "Leaflet", $01) <> 0) Then
                Return $00
            Else
                Return ((instr(arg0\Field1, "Note", $01) = $00) And (instr(arg0\Field1, "Log", $01) = $00))
            EndIf
    End Select
    Return $00
End Function

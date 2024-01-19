Function addscannedpathignore%(arg0$, arg1%)
    Local local0%
    local0 = arg1
    If (local0 = $01) Then
        While (instr(arg0, "\\", $01) <> 0)
            arg0 = replace(arg0, "\\", "\")
        Wend
        scanneddirignore[currentscanneddirsignore] = arg0
        currentscanneddirsignore = (currentscanneddirsignore + $01)
    EndIf
    Return $00
End Function

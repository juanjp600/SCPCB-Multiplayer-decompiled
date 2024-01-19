Function addscannedpath%(arg0$, arg1%)
    Select arg1
        Case $01
            While (instr(arg0, "\\", $01) <> 0)
                arg0 = replace(arg0, "\\", "\")
            Wend
            scanneddir[currentscanneddirs] = arg0
            currentscanneddirs = (currentscanneddirs + $01)
        Case $02
            While (instr(arg0, "\\", $01) <> 0)
                arg0 = replace(arg0, "\\", "\")
            Wend
            scanneddirfiles[currentscannedfiles] = arg0
            currentscannedfiles = (currentscannedfiles + $01)
    End Select
    Return $00
End Function

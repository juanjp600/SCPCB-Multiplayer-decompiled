Function loadcustommaps%()
    Local local0.custommaps
    Local local1.custommaps
    Local local2%
    Local local3$
    Local local4%
    catcherrors("LoadCustomMaps()")
    For local0 = Each custommaps
        Delete local0
    Next
    custommapsamount = $00
    If (filetype("Map Creator\Maps\") = $01) Then
        runtimeerrorex(format(getlocalstring("save", "cantcreatedir"), "Map Creator\Maps\", "%s"))
    EndIf
    If (filetype("Map Creator\Maps\") = $00) Then
        createdir("Map Creator\Maps\")
    EndIf
    local2 = readdir("Map Creator\Maps\")
    nextfile(local2)
    nextfile(local2)
    local3 = nextfile(local2)
    While (local3 <> "")
        If (filetype(("Map Creator\Maps\" + local3)) = $01) Then
            If (((right(local3, $06) = "cbmap2") Lor (right(local3, $05) = "cbmap")) <> 0) Then
                local4 = readfile_strict(("Map Creator\Maps\" + local3))
                local1 = (New custommaps)
                local1\Field0 = local3
                If (right(local3, $06) = "cbmap2") Then
                    local1\Field1 = readline(local4)
                Else
                    local1\Field1 = getlocalstring("creator", "unknown")
                EndIf
                closefile(local4)
                custommapsamount = (custommapsamount + $01)
            EndIf
        EndIf
        local3 = nextfile(local2)
    Wend
    closedir(local2)
    catcherrors("Uncaught: LoadCustomMaps()")
    Return $00
End Function

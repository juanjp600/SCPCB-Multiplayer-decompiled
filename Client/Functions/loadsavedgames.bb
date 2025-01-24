Function loadsavedgames%()
    Local local0.save
    Local local1.save
    Local local2%
    Local local3$
    Local local4%
    catcherrors("LoadSaveGames()")
    For local0 = Each save
        Delete local0
    Next
    savedgamesamount = $00
    If (filetype("Saves\") = $01) Then
        runtimeerrorex(format(getlocalstring("save", "cantcreatedir"), "Saves\", "%s"))
    EndIf
    If (filetype("Saves\") = $00) Then
        createdir("Saves\")
    EndIf
    local2 = readdir("Saves\")
    nextfile(local2)
    nextfile(local2)
    local3 = nextfile(local2)
    While (local3 <> "")
        If (filetype(("Saves\" + local3)) = $02) Then
            local4 = readfile_strict((("Saves\" + local3) + "\save.cb"))
            local1 = (New save)
            local1\Field0 = local3
            local1\Field1 = readstring(local4)
            local1\Field2 = readstring(local4)
            local1\Field3 = readstring(local4)
            If (readbyte(local4) = $00) Then
                local1\Field4 = readstring(local4)
            Else
                local1\Field4 = ("mc_" + readstring(local4))
            EndIf
            local1\Field5 = readstring(local4)
            closefile(local4)
            savedgamesamount = (savedgamesamount + $01)
        EndIf
        local3 = nextfile(local2)
    Wend
    closedir(local2)
    catcherrors("Uncaught: LoadSaveGames()")
    Return $00
End Function

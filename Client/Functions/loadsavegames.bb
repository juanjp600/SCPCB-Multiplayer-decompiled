Function loadsavegames%()
    Local local0%
    Local local1$
    Local local2%
    Local local3%
    Local local4%
    savegameamount = $00
    If (filetype(savepath) = $01) Then
        runtimeerror(((("Can't create dir " + chr($22)) + savepath) + chr($22)))
    EndIf
    If (filetype(savepath) = $00) Then
        createdir(savepath)
    EndIf
    local0 = readdir(savepath)
    Repeat
        local1 = nextfile(local0)
        If (local1 = "") Then
            Exit
        EndIf
        If (filetype(((savepath + "\") + local1)) = $02) Then
            If (((local1 <> ".") And (local1 <> "..")) <> 0) Then
                If (filetype(((savepath + local1) + "\save.txt")) > $00) Then
                    savegameamount = (savegameamount + $01)
                EndIf
            EndIf
        EndIf
    Forever
    closedir(local0)
    Dim savegames$((savegameamount + $01))
    local0 = readdir(savepath)
    local2 = $00
    Repeat
        local1 = nextfile(local0)
        If (local1 = "") Then
            Exit
        EndIf
        If (filetype(((savepath + "\") + local1)) = $02) Then
            If (((local1 <> ".") And (local1 <> "..")) <> 0) Then
                If (filetype(((savepath + local1) + "\save.txt")) > $00) Then
                    savegames(local2) = local1
                    local2 = (local2 + $01)
                EndIf
            EndIf
        EndIf
    Forever
    closedir(local0)
    Dim savegametime$((savegameamount + $01))
    Dim savegamedate$((savegameamount + $01))
    Dim savegameversion#((savegameamount + $01))
    Dim savegameseed$((savegameamount + $01))
    Dim savegamedifficulty%((savegameamount + $01))
    For local2 = $01 To savegameamount Step $01
        debuglog(((savepath + savegames((local2 - $01))) + "\save.txt"))
        local3 = readfile(((savepath + savegames((local2 - $01))) + "\save.txt"))
        savegametime((local2 - $01)) = readstring(local3)
        savegamedate((local2 - $01)) = readstring(local3)
        readint(local3)
        For local4 = $00 To $05 Step $01
            readfloat(local3)
        Next
        readstring(local3)
        readfloat(local3)
        readfloat(local3)
        savegameversion((local2 - $01)) = readfloat(local3)
        savegameseed((local2 - $01)) = readstring(local3)
        savegamedifficulty((local2 - $01)) = readbyte(local3)
        closefile(local3)
    Next
    Return $00
End Function

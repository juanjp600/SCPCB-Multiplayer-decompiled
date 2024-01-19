Function loadsavedmaps%()
    Local local0%
    Local local1%
    Local local2$
    Local local3%
    For local0 = $00 To savedmapsamount Step $01
        savedmaps(local0) = ""
        savedmapsauthor(local0) = ""
    Next
    savedmapsamount = $00
    local1 = readdir("Map Creator\Maps")
    Repeat
        local2 = nextfile(local1)
        debuglog(local2)
        If (local2 = "") Then
            Exit
        EndIf
        debuglog(((currentdir() + "Map Creator\Maps\") + local2))
        If (filetype(((currentdir() + "Map Creator\Maps\") + local2)) = $01) Then
            If (((local2 <> ".") And (local2 <> "..")) <> 0) Then
                If (((right(local2, $06) = "cbmap2") Or (right(local2, $05) = "cbmap")) <> 0) Then
                    savedmapsamount = (savedmapsamount + $01)
                EndIf
            EndIf
        EndIf
    Forever
    closedir(local1)
    Dim savedmaps$((savedmapsamount + $01))
    Dim savedmapsauthor$((savedmapsamount + $01))
    local0 = $00
    local1 = readdir("Map Creator\Maps")
    Repeat
        local2 = nextfile(local1)
        debuglog(local2)
        If (local2 = "") Then
            Exit
        EndIf
        debuglog(((currentdir() + "Map Creator\Maps\") + local2))
        If (filetype(((currentdir() + "Map Creator\Maps\") + local2)) = $01) Then
            If (((local2 <> ".") And (local2 <> "..")) <> 0) Then
                If (((right(local2, $06) = "cbmap2") Or (right(local2, $05) = "cbmap")) <> 0) Then
                    savedmaps(local0) = local2
                    If (right(local2, $06) = "cbmap2") Then
                        local3 = readfile(("Map Creator\Maps\" + local2))
                        savedmapsauthor(local0) = readline(local3)
                        closefile(local3)
                    Else
                        savedmapsauthor(local0) = "[Unknown]"
                    EndIf
                    local0 = (local0 + $01)
                EndIf
            EndIf
        EndIf
    Forever
    closedir(local1)
    Return $00
End Function

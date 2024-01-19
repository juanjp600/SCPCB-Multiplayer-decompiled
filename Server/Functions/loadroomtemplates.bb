Function loadroomtemplates%(arg0$)
    Local local0$
    Local local1%
    Local local2.roomtemplates
    Local local3$
    Local local4%
    local2 = Null
    local3 = ""
    local4 = readfile(arg0)
    If (local4 = $00) Then
        runtimeerror((("File " + arg0) + " doesn't exist"))
    EndIf
    While (eof(local4) = $00)
        local0 = trim(readline(local4))
        If (left(local0, $01) = "[") Then
            local0 = mid(local0, $02, (len(local0) - $02))
            local3 = getinistring(arg0, local0, "mesh path", "")
            local2 = createroomtemplate(local3)
            local2\Field10 = lower(local0)
            local3 = lower(getinistring(arg0, local0, "shape", ""))
            Select local3
                Case "room1","1"
                    local2\Field9 = $01
                Case "room2","2"
                    local2\Field9 = $02
                Case "room2c","2c"
                    local2\Field9 = $03
                Case "room3","3"
                    local2\Field9 = $04
                Case "room4","4"
                    local2\Field9 = $05
            End Select
            For local1 = $00 To $04 Step $01
                local2\Field3[local1] = getiniint(arg0, local0, ("zone" + (Str (local1 + $01))), $00)
            Next
            local2\Field11 = (Int max(min((Float getiniint(arg0, local0, "commonness", $00)), 100.0), 0.0))
            local2\Field12 = getiniint(arg0, local0, "large", $00)
            local2\Field13 = getiniint(arg0, local0, "disabledecals", $00)
            local2\Field17 = getiniint(arg0, local0, "usevolumelighting", $00)
            local2\Field18 = getiniint(arg0, local0, "disableoverlapcheck", $00)
        EndIf
    Wend
    local1 = $01
    Repeat
        local3 = getinistring(arg0, "room ambience", ("ambience" + (Str local1)), "")
        If (local3 = "") Then
            Exit
        EndIf
        roomambience[local1] = loadsound_strict(local3)
        local1 = (local1 + $01)
    Forever
    closefile(local4)
    Return $00
End Function

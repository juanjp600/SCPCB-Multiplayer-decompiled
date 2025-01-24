Function loadroomtemplates%(arg0$)
    Local local0$
    Local local1%
    Local local2.roomtemplates
    Local local3$
    Local local4%
    catcherrors((("LoadRoomTemplates(" + arg0) + ")"))
    local2 = Null
    local3 = ""
    local4 = openfile_strict(arg0)
    While (eof(local4) = $00)
        local0 = trim(readline(local4))
        If (left(local0, $01) = "[") Then
            local0 = mid(local0, $02, (len(local0) - $02))
            If (local0 <> "room ambience") Then
                local3 = inigetstring(arg0, local0, "Mesh Path", "", $01)
                local2 = createroomtemplate(local3)
                local2\Field5 = lower(local0)
                local2\Field6 = findroomid(local2\Field5)
                local3 = inigetstring(arg0, local0, "Shape", "", $01)
                Select local3
                    Case "1"
                        local2\Field4 = $00
                    Case "2"
                        local2\Field4 = $01
                    Case "2C"
                        local2\Field4 = $02
                    Case "3"
                        local2\Field4 = $03
                    Case "4"
                        local2\Field4 = $04
                End Select
                For local1 = $00 To $04 Step $01
                    local2\Field3[local1] = inigetint(arg0, local0, ("Zone" + (Str (local1 + $01))), $00, $01)
                Next
                local2\Field7 = (Int clamp((Float inigetint(arg0, local0, "Commonness", $00, $01)), 0.0, 100.0))
                local2\Field8 = inigetint(arg0, local0, "DisableDecals", $00, $01)
                local2\Field9 = inigetint(arg0, local0, "DisableOverlapCheck", $00, $01)
            EndIf
        EndIf
    Wend
    local1 = $00
    Repeat
        local3 = inigetstring(arg0, "room ambience", ("Ambience" + (Str local1)), "", $01)
        If (local3 = "") Then
            Exit
        EndIf
        roomambience[local1] = loadsound_strict(local3)
        local1 = (local1 + $01)
    Forever
    closefile(local4)
    catcherrors((("Uncaught: LoadRoomTemplates(" + arg0) + ")"))
    Return $00
End Function

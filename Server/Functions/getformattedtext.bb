Function getformattedtext$(arg0$)
    Local local0$
    Local local1$
    Local local2$
    Local local3%
    Local local4%
    Local local5$
    local3 = $00
    For local4 = $01 To len(arg0) Step $01
        local3 = $00
        local0 = mid(arg0, local4, $01)
        If (local0 = "%") Then
            local2 = piece(right(arg0, (Int max((Float ((len(arg0) - local4) + $02)), 0.0))), $02, "%")
            local5 = ""
            Select local2
                Case "r","g","b","y","w","p"
                Default
                    local3 = (local3 + $01)
            End Select
            Select piece(local2, $01, "|")
                Case "color","font","align","alignfix","tab","clickable"
                Default
                    local3 = (local3 + $01)
            End Select
            If (local3 = $02) Then
                local3 = $00
            Else
                local4 = ((len(local2) + local4) + $01)
            EndIf
        Else
            local3 = $00
        EndIf
        If (local3 = $00) Then
            local1 = (local1 + local0)
        EndIf
    Next
    Return local1
    Return ""
End Function

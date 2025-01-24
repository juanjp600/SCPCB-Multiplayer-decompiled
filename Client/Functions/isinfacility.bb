Function isinfacility%(arg0#)
    Local local0#
    local0 = floor(arg0)
    If (-6.5 > local0) Then
        Return $FFFFFFFF
    ElseIf (((6.5 < local0) And (100.0 >= local0)) <> 0) Then
        Return $01
    ElseIf (((100.0 < local0) And (700.0 > local0)) <> 0) Then
        Return $02
    ElseIf (400.0 < local0) Then
        Return $03
    EndIf
    Return $00
    Return $00
End Function

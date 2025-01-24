Function findeventvariable%(arg0.events)
    Select arg0\Field0
        Case $0E
            scribe_event = arg0
        Case $10
            skull_event = arg0
        Case $39
            forest_event = arg0
        Case $48
            pd_event = arg0
    End Select
    Return $00
End Function

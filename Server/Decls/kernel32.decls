.lib "kernel32.dll"

api_closehandle%(param0%):"CloseHandle"
api_getcurrentprocessid%():"GetCurrentProcessId"
api_getsystemtime%(param0*):"GetSystemTime"
api_openprocess%(param0%, param1%, param2%):"OpenProcess"
api_terminateprocess%(param0%, param1%):"TerminateProcess"

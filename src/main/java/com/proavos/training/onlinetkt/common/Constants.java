package com.proavos.training.onlinetkt.common;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class Constants {
    public enum Status {
        ACT("Active"), INA("Inactive");

        private String description;

        private Status(String description) {
            this.description = description;
        }

        public static Status resolveStatus(String statusStr) {
            Status matchingStatus = null;
            if (!StringUtils.isEmpty(statusStr)) {
                matchingStatus = valueOf(statusStr.trim());
            }
            return matchingStatus;
        }

        public static Map<String, String> getStatusMap() {
            Map<String, String> map = new LinkedHashMap<String, String>();
            for (Status status : Status.values()) {
                map.put(status.toString(), status.getDescription());
            }
            return map;
        }

        public String getDescription() {
            return description;
        }
    }

	public enum BusStatus {
		ACT("Active"), CNX("Cancelled");

		private String description;

		private BusStatus(String description) {
			this.description = description;
		}

		public static BusStatus resolveStatus(String statusStr) {
			BusStatus matchingStatus = null;
			if (!StringUtils.isEmpty(statusStr)) {
				matchingStatus = valueOf(statusStr.trim());
			}
			return matchingStatus;
		}

		public static Map<String, String> getStatusMap() {
			Map<String, String> map = new LinkedHashMap<String, String>();
			for (BusStatus status : BusStatus.values()) {
				map.put(status.toString(), status.getDescription());
			}
			return map;
		}

		public String getDescription() {
			return description;
		}
	}

	public enum BookingStatus {
		CNF("Confirmed"), OHD("OnHold"), CNX("Cancelled");

		private String description;

		private BookingStatus(String description) {
			this.description = description;
		}

		public static BookingStatus resolveStatus(String statusStr) {
			BookingStatus matchingStatus = null;
			if (!StringUtils.isEmpty(statusStr)) {
				matchingStatus = valueOf(statusStr.trim());
			}
			return matchingStatus;
		}

		public static Map<String, String> getStatusMap() {
			Map<String, String> map = new LinkedHashMap<String, String>();
			for (BookingStatus status : BookingStatus.values()) {
				map.put(status.toString(), status.getDescription());
			}
			return map;
		}

		public String getDescription() {
			return description;
		}
	}
}
